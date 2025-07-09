package com.example;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.stream.StreamSource;

import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.Serializer;
import net.sf.saxon.s9api.XQueryCompiler;
import net.sf.saxon.s9api.XQueryEvaluator;
import net.sf.saxon.s9api.XQueryExecutable;

public class XQueryDemo {

	public static void main(String[] args) throws SaxonApiException, IOException {
		// TODO Auto-generated method stub
		Processor proc = new Processor();
		XQueryCompiler compiler = proc.newXQueryCompiler();
		
		XQueryExecutable exec = compiler.compile(new File("src/main/resources/book1.sqy"));
		
		XQueryEvaluator evaluator = exec.load();
		
		evaluator.setSource(new StreamSource(new File("src/main/resources/Books.xml")));
		
		Serializer out = proc.newSerializer(System.out);
        out.setOutputProperty(Serializer.Property.METHOD, "xml");
        evaluator.run(out);
		
	}

}
