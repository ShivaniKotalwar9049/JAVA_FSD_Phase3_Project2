package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.hibernate.type.descriptor.java.UUIDTypeDescriptor.ToBytesTransformer;

public class ImageUtil {
	
	//compress an image -util.zip.deflater
	
	public static byte[] compress(byte[] data)
	{
		Deflater deflater=new Deflater();
		deflater.setLevel(Deflater.BEST_COMPRESSION);
		deflater.setInput(data);
		deflater.finish();
		
		ByteArrayOutputStream out=new ByteArrayOutputStream(data.length);
		byte[] temp=new byte[1024*4];
		
		while(!deflater.finished())
		{
			int size=deflater.deflate(temp);
			out.write(temp,0,size);
		}
		return out.toByteArray();
		
	}

	
	public static byte[] decompress(byte[] data) throws DataFormatException
	{
		Inflater inflater=new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream out=new ByteArrayOutputStream(data.length);
		byte[] temp=new byte[1024*4];
		while(!inflater.finished())
		{
			int size=inflater.inflate(temp);
			out.write(temp,0,size);
		}
		return out.toByteArray();
	}
}
