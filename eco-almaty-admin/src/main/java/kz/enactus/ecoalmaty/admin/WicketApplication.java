package kz.enactus.ecoalmaty.admin;

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import org.apache.wicket.Page;
import org.apache.wicket.csp.CSPDirective;
import org.apache.wicket.csp.CSPDirectiveSrcValue;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WicketApplication extends WicketBootStandardWebApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(WicketApplication.class)
                .run(args);
    }

    @Override
    protected void init() {
        super.init();

        getCspSettings().blocking().add(CSPDirective.STYLE_SRC, CSPDirectiveSrcValue.SELF);
    }

    @Override
    public Class<? extends Page> getHomePage() {
        return HomePage.class;
    }

}
