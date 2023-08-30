package kz.enactus.ecoalmaty.admin;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomePage extends WebPage {

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
	}

}
