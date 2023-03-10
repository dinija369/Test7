public class FileUploadServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String contentType = request.getContentType();
        
        // the starting position of the boundary header
        int ind = contentType.indexOf("boundary=");
        String boundary = contentType.substring(ind+9);
        
        String pLine = new String();
        String uploadLocation = new String(UPLOAD_DIRECTORY_STRING); //Constant value
        
        // verify that content type is multipart form data
        if (contentType != null && contentType.indexOf("multipart/form-data") != -1) {
        // extract the filename from the Http header
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        pLine = br.readLine();
        String filename = pLine.substring(pLine.lastIndexOf("\\"), pLine.lastIndexOf("\""));
        
        // output the file to the local upload directory
        try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(uploadLocation+filename, true));
        for (String line; (line=br.readLine())!=null; ) {
        if (line.indexOf(boundary) == -1) {
        bw.write(line);
        bw.newLine();
        bw.flush();
        }
        } //end of for loop
        bw.close();
        
        
        } catch (IOException ex) {}
        // output successful upload response HTML page
        }
        // output unsuccessful upload response HTML page
        else
        {}
    }
}