package backend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JavaFilesHandler {

	private File src;

	private List<JavaPackage> package_list = new ArrayList<JavaPackage>();
	private int numberOfPackages = 0;
	

	public JavaFilesHandler(String project_path) {
		this.src = new File(project_path + "\\src");
		search(src);
	}

	public void search(File folder) {

		for (final File f : folder.listFiles()) {
			if (f.isDirectory()) {
				//System.out.println(f.getName());
				search(f);
				JavaPackage p = new JavaPackage(f.getName(), f);
				package_list.add(p);
				numberOfPackages++;
			}
		}
	}

	public int getNumberOfPackages() {
		return numberOfPackages;
	}

	public int countTotalOfClasses() {
		int total=0;
		for(int i=0;i<package_list.size();i++) {
		JavaPackage p=package_list.get(i);
			total=total+p.numberOfClasses();
		}
		return total; 
	}
	
	public static void main(String[] args) {

		String path = "C:\\Users\\vasco\\Desktop\\teste";

		JavaFilesHandler j = new JavaFilesHandler(path);
		System.out.println(j.getNumberOfPackages());

	}



}
