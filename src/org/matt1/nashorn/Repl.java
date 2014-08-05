package org.matt1.nashorn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Repl {

	public static void main(String[] args) throws IOException, ScriptException {
		Repl r = new Repl();
		r.go();
	}
	

	

	
	private void go() throws IOException {
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		Boolean run = true;
		
		BufferedReader buffIn = new BufferedReader(new InputStreamReader(System.in));
		
		while (run) {
			
			String line = buffIn.readLine();
			if (line == null) {
				run = false;
				break;
			}
			Object result = null;
			try {
				result = engine.eval(line);
			} catch (ScriptException se) {
				System.out.println(se.getMessage());
			}
			if (result != null) {
				System.out.println(result);
			}
			
		}

		
	}
	
	
}
