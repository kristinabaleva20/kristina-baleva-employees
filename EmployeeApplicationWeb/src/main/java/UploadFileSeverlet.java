import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

import static constants.FileConstants.*;
import static constants.JSPConastants.*;


@WebServlet(urlPatterns={"/uploadFile"})
@MultipartConfig
public class UploadFileSeverlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String savedPath=null;
        String uploadPath = getServletContext().getRealPath(RELATIVE_PATH) + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();


        for (Part part : req.getParts()) {
            String fileName = getFileName(part);
            savedPath = uploadPath + File.separator + fileName;
            part.write(savedPath);

        }

        req.setAttribute(MESSAGE, FILE_UPLOADED_SUCCESSFULLY);
        req.setAttribute(FILE_PATH, savedPath);
        final RequestDispatcher rd = req.getRequestDispatcher(PROCESS_JSP);
        rd.forward(req, resp);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader(CONTENT_DISPOSITION).split(_REGEX_SEPARATOR)) {
            if (content.trim().startsWith(FILENAME))
                return content.substring(content.indexOf(SYMBOL) + 2, content.length() - 1);

        }
        return DEFAULT;
    }
}
