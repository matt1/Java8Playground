package org.matt1.nashorn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

public class Repl {

	/**
	 * Creates a simple nashorn REPL nased on System.out & System.in.  Use exit() 
	 * to quit.
	 * 
	 * @param args
	 * @throws IOException
	 * @throws ScriptException
	 */
	public static void main(String[] args) throws IOException, ScriptException {
		Repl r = new Repl();
		r.go();
	}
	
	// Note that classes must be public in order for  instances to be
	// accessed from the javascript environment, otherwise members cannot be
	// found (e.g. "TypeError: org.matt1.nashorn.Repl$myObject@14168b8 has no 
	// such function "getValue" in <eval> at line number 1")	
	public class myObject {
		
		private String value;
		private int changes = 0;
		
		
		public String getValue() {
			return value;
		}

		public int getChanges() {
			return changes;
		}
		
		public void setValue(String value) {
			changes++;
			this.value = value;
		}
		
	}

	
	private void go() throws IOException {				
		
		NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
		
		// More info on these options here:
		// https://wiki.openjdk.java.net/display/Nashorn/Nashorn+extensions
		String[] opts = new String[]{
				"-strict", 	// run in strict ECMAScript 5.1 mode
				"-nj", 		// no java support
				"-nse"};	// No special syntax extensions
		ScriptEngine engine = factory.getScriptEngine(opts);
			
		Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);

		// bindings.keySet() will contain all new global variables/functions etc.
		// but does not contain normal globals (e.g. exit) etc.  Could be useful for
		// introspection and 
		
		Boolean run = true;
		
		BufferedReader buffIn = new BufferedReader(new InputStreamReader(System.in));
		
		// Put an instance into the engine's scope.
		// This instance then becomes a two-way street with changes made in javascript
		// changing in the java object, and changes in the javascript changing in the
		// javascript object too
		myObject myObj1 = new myObject();
		myObj1.setValue("one");
		engine.put("o1", myObj1);
		
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
