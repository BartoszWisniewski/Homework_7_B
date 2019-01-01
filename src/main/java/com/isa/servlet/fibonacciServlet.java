package com.isa.servlet;

import com.isa.service.fibonacciService;
import com.isa.template.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/")
public class fibonacciServlet extends HttpServlet {

    private Logger LOG = LoggerFactory.getLogger(fibonacciServlet.class);

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private fibonacciService fibonacciService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        final String TEMPLATE_NAME = "index";

        Map<String, Object> model = new HashMap<>();
        model.put("date", LocalDateTime.now());
        model.put("grup", "jjdd5-zajavka");
        model.put("student", "Bartosz Wisniewski");

        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.info("error ", e);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String TEMPLATE_NAME = "table";
        Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

        final String numberStr = req.getParameter("number");

        LOG.info("Insert number: {}", numberStr);

        BigDecimal bigNumber = new BigDecimal(numberStr);

        if (!(bigNumber.signum() == 0 || bigNumber.scale() <= 0 || bigNumber.stripTrailingZeros().scale() <= 0)) {
            LOG.info("Insert number ins't integer: {}", numberStr);
            resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        } else {

            Integer number = bigNumber.intValue();

            Integer fibonacci = fibonacciService.findNumber(number);

            List<Integer> fibonacciList = fibonacciService.listNumber(number);

            Map<String, Object> model = new HashMap<>();
            model.put("fibonacci", fibonacci);
            model.put("List", fibonacciList);

            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                LOG.info("error ", e);
                e.printStackTrace();
            }
        }

    }
}
