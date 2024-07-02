package sn.lamp.dev.service.impl;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.servlet.ServletContext;

import sn.lamp.dev.service.UploadImage;
@Service
public class UploadImageImpl implements UploadImage {
	@Autowired
	ServletContext context;
	@Override
	public File getPathService(String filename, String path) {
		// TODO Auto-generated method stub
	
			boolean exits = new File(context.getRealPath("/" + path + "/")).exists();
			if (!exits)
				new File(context.getRealPath("/" + path + "/")).mkdir();
			String yone = context.getRealPath("/" + path + "/" + filename);
			File fil = new File(yone);
			return fil;
		}
	


}
