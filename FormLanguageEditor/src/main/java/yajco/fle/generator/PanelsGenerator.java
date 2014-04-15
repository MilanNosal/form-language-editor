package yajco.fle.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Properties;
import javax.annotation.processing.Filer;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import yajco.generator.FilesGenerator;
import yajco.model.Language;

/**
 *
 * @author DeeL
 */
public class PanelsGenerator implements FilesGenerator {

    @Override
    public void generateFiles(Language language, Filer filer, Properties properties) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected static final String VELOCITY_PROPERTIES_FILE = "velocity.properties";
    protected static final String TEMPLATE_PACKAGE = "yajco/fle/generator/templates";
    protected static VelocityEngine velocityEngine;
    protected final String template;

    static {
        try {
            Properties velocityProperties = new Properties();
            velocityProperties.load(ClassLoader.getSystemClassLoader().getResourceAsStream(VELOCITY_PROPERTIES_FILE));
            velocityEngine = new VelocityEngine(velocityProperties);
        } catch (Exception e) {
            throw new ConfigurationException("Failed during loading of the configuration file '" + VELOCITY_PROPERTIES_FILE + "'", e);
        }
    }

    public TemplateGenerator(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }

    protected void generate(Writer writer, Map<String, Object> params) throws GeneratorException {
        try {
            //Prepare context
            VelocityContext context = new VelocityContext(params);

            //Add generator
            context.put("generator", this);

            //Evaluate the template - generates output
            String path = TEMPLATE_PACKAGE + "/" + template + ".java.vsl";

            InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "utf-8");
            velocityEngine.evaluate(context, writer, "", reader);
            reader.close();
        } catch (IOException e) {
            throw new GeneratorException("Cannot generate output for template " + getTemplate(), e);
        }
    }

    protected PrintWriter createWriter(String fileName) throws GeneratorException {
        try {
            File file = new File(fileName);
            file.getParentFile().mkdirs();
            return new PrintWriter(file);
        } catch (IOException e) {
            throw new GeneratorException("Cannot write generated output to file '" + fileName + "'", e);
        }
    }
}
