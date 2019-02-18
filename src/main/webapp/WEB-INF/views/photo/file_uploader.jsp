<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.awt.Image"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="servername" value="${pageContext.request.serverName}"></c:set>
<c:set var="serverport" value="${pageContext.request.serverPort}"></c:set>


<c:choose>
	<c:when test="${isBiggerThanMax eq true}">
		<script>alert("업로드 용량(총 10Mytes)을 초과하였습니다.");history.back();</script>
	</c:when>
	<c:otherwise>
		<form id="fileform" name="fileform" method="post">
			<input type="hidden" name="filename" 	value="${filename}">
			<input type="hidden" name="photo_dir"	value="<c:url value="${photo_dir }"/>">
		</form>
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	function fileAttach(){ 
		f = document.fileform;
		// fpath 	= f.path.value;
	    fname 	= f.filename.value; 
	    dir 	= f.photo_dir.value; 
	    // fcode 	= fpath + fname;
	    
	    try{
	    	window.opener.$("#targetUpload").val(dir);
	    	window.opener.$("#temp_src").attr("src", "${servername}:${serverport}"+dir);
            // window.opener.$("#representImg").val(fname);
            // window.opener.$("#img_uploaded").attr("src", "<c:url value='/resources/upload/"+fname+"'/>");
	    	// window.close();
	    }catch(e){ 
//           alert(e); 
	    }
	}
	fileAttach();
	this.window.close();
</script>
