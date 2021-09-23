import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class RequestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // Read out html file and assign the contents to a String variable, named "websiteHtml"
        String websiteHtml = FileUtils.readFileToString(new File("website.html"), StandardCharsets.UTF_8);
        // Tell the browser HTTP code 200 (which means success) and how long the html file is
        exchange.sendResponseHeaders(200, websiteHtml.getBytes().length);
        // Get our stream where we will send the HTML
        OutputStream outputStream = exchange.getResponseBody();
        // Write the HTML to this stream
        outputStream.write(websiteHtml.getBytes());
        // Close everything
        outputStream.flush();
        outputStream.close();
        exchange.close();
    }
}
