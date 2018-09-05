package cn.springboot.util;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


public class CreateCode {
	
	/*
	 * final int width = 300;//宽度F:/img2.png
		final int height = 300;//高度
		final String format = "png";//图片格式
		final String contents = "http://wx2.htjs.net/wxgzh/fwpj/fwpjRY.html?CZRY_DM=8a8a8a8e376ce63301376cff2405000b";//内容
	 * */
	public static void createZxing(String contents,String path,String name){
		final String pa = path+File.separator+name+".png";
		final int width = 300;//宽度
		final int height = 300;//高度
		final String format = "png";//图片格式
		HashMap<EncodeHintType, Comparable> hints = new HashMap<EncodeHintType, Comparable>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height,hints);
			Path file = new File(pa).toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {
		}
	}

}
