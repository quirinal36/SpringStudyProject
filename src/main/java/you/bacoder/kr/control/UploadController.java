package you.bacoder.kr.control;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import you.bacoder.kr.vo.UserVO;

@Controller
public class UploadController extends BacoderController{
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value="/photo_upload")
	public ModelAndView getUploadView(ModelAndView mv) {
		UserVO user = getUser();
		if(user.getId() > 0) {
			logger.info(getUploadDir(user.getId()).getAbsolutePath());
		}
		mv.setViewName("/photo/photo_uploader");
		return mv;
	}
	
	@RequestMapping(value="/file_upload")
	public ModelAndView getFileUploadView(ModelAndView mv, HttpServletRequest request) throws IOException {
		UserVO user = getUser();
		if(user.getId() > 0) {
			logger.info(getUploadDir(user.getId()).getAbsolutePath());
			final String srcPath = request.getSession().getServletContext().getRealPath("/upload");
			File srcPathFile = new File(srcPath);
			if(!srcPathFile.exists()) {
				srcPathFile.mkdirs();
			}
			MultipartRequest multi=new MultipartRequest(request, srcPath, 15*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			SimpleDateFormat formatter2 = new SimpleDateFormat ("yyyy_MM_dd_HHmmssSSS", java.util.Locale.KOREA);
			String upfile = (multi.getFilesystemName("Filedata"));
			
			if (!upfile.equals("")) {
				String dateString = formatter2.format(new java.util.Date());
				String moveFileName = dateString + upfile.substring(upfile.lastIndexOf(".") );
				File sourceFile = new File(srcPath , upfile);
				File targetFile = new File(getUploadDir(user.getId()), moveFileName);
				BufferedImage img = ImageIO.read(sourceFile);
				
				ImageIO.write(img, "JPEG", targetFile);
				
				mv.addObject("filename", moveFileName);
				mv.addObject("photo_dir", "/upload/you.bacoder.kr/"+user.getId()+"/"+moveFileName);
			}
		}
		mv.setViewName("/photo/file_uploader");
		return mv;
	}
	
	private File getUploadDir(int id) {
		final String userUploadDir = new StringBuilder()
				.append("webapps").append(File.separator)
				.append("upload").append(File.separator)
				.append("you.bacoder.kr").append(File.separator)
				.append(id).toString();
		final String workingDir = System.getProperty("user.dir");
		File parentDir = new File(workingDir).getParentFile();
		File uploadDir = new File(parentDir, userUploadDir);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		return uploadDir;
	}
}
