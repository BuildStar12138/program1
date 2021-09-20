package keywordExtraction;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
	private int keyword;
	private SwitchAndCase switchAndcase;
	//private IfElse ifElse;
	//private ElseIf  elseIf;
	private TreeSet<String> treeSet = new TreeSet<>();
	public Counter() {
		keyword = 0;
		switchAndcase = new SwitchAndCase();
	}
	public void buildSet() {
		String[] keywords = {"auto","break","case","char","const",
			"continue","default","do","double","else","enum","extern",
			"for","goto","if","int","long","register","return","short",
			"signed","sizeof","static","struct","switch","typedef",
			"union","unsigned","void","volatile","float","while"};
		for(String e:keywords) {
			treeSet.add(e);
		}
	}
	public void count(String line) {
		if(line == null) {
			switchAndcase.addCaseNum();
			return ;
		}
		String regex = "[a-zA-Z]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(line);
		while (m.find()) {
			if(treeSet.contains(m.group())) {
				keyword++;
				switchAndcase.find(m.group());
			}
		}
	}
	public void getOut() {
		System.out.println("total num: "+keyword);
		switchAndcase.getSwitchAndCase();
	}

}
