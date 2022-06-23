package com.Deneme.firstHw;

import java.nio.file.Path;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Developer;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name="summarize" , defaultPhase = LifecyclePhase.INSTALL)
public class DependencyHw1 extends AbstractMojo{
	
	@Parameter(defaultValue="${project}", required=true)
	private MavenProject project;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
	// TODO Auto-generated method stub	
		try {

			  String userDirectory=System.getProperty("user.dir");
			  String outputPath=userDirectory+"\\target\\hw.txt";
			  FileWriter myWriter = new FileWriter(outputPath);
		      myWriter.write("Project Info :\t"+project.getGroupId()+"."+project.getArtifactId()+"."+project.getVersion());
		      
		      myWriter.write("\n\nProject Developers:\t");
		      List<Developer>developers=project.getDevelopers();
			  for(Developer d: developers) {
				  myWriter.write("\nDeveloper :\t"+d.getName());
			  }
			  
			  myWriter.write("\n\nRelease Date:\t"+project.getProperties().getProperty("release.date"));
			  
			  myWriter.write("\n\nProject Dependencies:\t");
			  List<Dependency>dependencies = project.getDependencies();
			  for(Dependency d: dependencies) {
				  myWriter.write("\nDependency :\t"+d.getGroupId()+"."+d.getArtifactId());
			  }
			  
			  myWriter.write("\n\nProject Plugins:\t");
			  Set<Artifact>plugins=project.getPluginArtifacts();
			  for(Artifact d: plugins) {
				  myWriter.write("\nPlugin: "+d.getArtifactId()+"          "+d.getVersion());
			  }
			 
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
			
	}
	
		
}

