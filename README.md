# Maven-Custom-Plugin

This Plugin, It will read
project version
group id
artifact id
dependencies
plugins
developers
and a property named release.date given as property.
This plugin will read some information of the project it is running from pom.xml and create a summary file.
This plugin will have one goal. Its name may be summarized.
And we will get one parameter called outputFile. This will be the name of the file where we will write the summary we receive. (The file will be created under the target folder)
