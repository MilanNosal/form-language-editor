package yajco.fle.generator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.annotation.processing.Filer;
import javax.tools.JavaFileObject;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import yajco.fle.generator.transform.YajcoModelToLocalModelTransformator;
import yajco.fle.model.Concept;
import yajco.fle.model.ConcreteConcept;
import yajco.fle.model.Property;
import yajco.fle.model.properties.ReferenceProperty;
import yajco.generator.FilesGenerator;
import yajco.generator.annotation.DependsOn;
import yajco.model.Language;

/**
 *
 * @author DeeL
 */
@DependsOn("yajco.generator.printergen.PrettyPrinterGenerator")
public class PanelsGenerator implements FilesGenerator {

    protected static final String PACKAGE_NAME = "generated";
    protected static final String PRINTER_PANEL_TEMPLATE = "PrinterPanel.java.vsl";
    protected static final String PRINTER_PANEL_CLASS_NAME = "PrinterPanelImpl";

    public static void main(String[] args) {
        new PanelsGenerator().generateFiles(null, null, null);
    }

    @Override
    public void generateFiles(Language language, Filer filer, Properties properties) {
        //yajco.fle.model.Language lang = createDummy(); //YajcoModelToLocalModelTransformator.transform(language);
        yajco.fle.model.Language lang = YajcoModelToLocalModelTransformator.transform(language);

        try {
            Map<String, Object> params = new HashMap<>();
            params.put("generator", this);
            params.put("package", PACKAGE_NAME);
            params.put("printerPanelImplClassName", PRINTER_PANEL_CLASS_NAME);
            params.put("language", lang);

            for (Concept concept : lang.getConcepts()) {
                JavaFileObject jfo = filer.createSourceFile(PACKAGE_NAME + "." + concept.getName() + "Panel");
                try (InputStreamReader reader = new InputStreamReader(language.getClass().getResourceAsStream(TEMPLATE_PACKAGE + "/" + CONCEPT_TEMPLATE), "utf-8");
                        Writer writer = new BufferedWriter(jfo.openWriter())) {
                    VelocityContext context = new VelocityContext(params);
                    context.put("concept", concept);
                    velocityEngine.evaluate(context, writer, "", reader);
                }
            }

            JavaFileObject jfo = filer.createSourceFile(PACKAGE_NAME + "." + PRINTER_PANEL_CLASS_NAME);
            try (InputStreamReader reader = new InputStreamReader(language.getClass().getResourceAsStream(TEMPLATE_PACKAGE + "/" + PRINTER_PANEL_TEMPLATE), "utf-8");
                    Writer writer = new BufferedWriter(jfo.openWriter())) {
                VelocityContext context = new VelocityContext(params);
                context.put("printerClass", yajco.generator.printergen.PrettyPrinterGenerator.PRINTER_CLASS_NAME);
                context.put("printerSubpackage", yajco.generator.printergen.PrettyPrinterGenerator.PRINTER_PACKAGE);
                velocityEngine.evaluate(context, writer, "", reader);
            }

        } catch (IOException e) {
            throw new RuntimeException("Cannot generate output.", e);
        }

    }

    public Set<Class> getPanelClasses(Concept concept) {
        Set<Class> retVal = new HashSet<>();
        if (concept instanceof ConcreteConcept) {
            for (Property property : ((ConcreteConcept) concept).getProperties()) {
                retVal.add(property.getClass());
            }
        }
        return retVal;
    }

    public String toUCIdent(String ident) {
        return Character.toUpperCase(ident.charAt(0)) + ident.substring(1);
    }

    public String toLCIdent(String ident) {
        return Character.toLowerCase(ident.charAt(0)) + ident.substring(1);
    }

    /**
     * Vystrihnutie mena konceptu, ktore potom pouzivam pre pracu vdaka mennym
     * konvenciam. Teda uvidim ci pouzijem, zatial asi ani nie.
     *
     * @param property
     * @return
     */
    public String getPropertyTypeName(Property property) {
        String propSimpleName = property.getClass().getSimpleName();
        return propSimpleName.substring(0, propSimpleName.length() - 8);
    }
    
    public Set<ReferenceProperty> getUniqueReferenceProperties(ConcreteConcept concept) {
        Set<ReferenceProperty> references = new HashSet<>();
        for(Property property : concept.getProperties()) {
            if(property instanceof ReferenceProperty) {
                references.add((ReferenceProperty) property);
            }
        }
        return references;
    }

    public PanelsGenerator() {
    }

    protected static final String VELOCITY_PROPERTIES_FILE = "/velocity.properties";
    protected static final String TEMPLATE_PACKAGE = "/yajco/fle/generator/templates";
    protected static final VelocityEngine velocityEngine;
    protected static final String CONCEPT_TEMPLATE = "Concept.java.vsl";

    static {
        try {
            Properties velocityProperties = new Properties();
            velocityProperties.load(PanelsGenerator.class.getResourceAsStream(VELOCITY_PROPERTIES_FILE));
            velocityEngine = new VelocityEngine(velocityProperties);
        } catch (Exception e) {
            throw new ConfigurationException("Failed during loading of the configuration file '" + VELOCITY_PROPERTIES_FILE + "'", e);
        }
    }
}
