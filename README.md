# Soot_Compiler_Talk
This is the home of where all files associated with the compiler talk.
## Compiling
Use `javac Main.java FixedMethods.java -cp ../JarLibraries/*` when compiling java files. Be sure you are in the Java folder.
## Running code
Use `java -cp "..\\JarLibraries\\*;" Main -allow-phantom-refs -android-jars ..\\Android/platforms -android-api-version 28 -src-prec apk -output-format dex -force-overwrite -output-dir "OutputJimple" -process-dir "..\APK\SimpleAd.apk"  -process-multiple-dex -w -p db.transformations enabled:true` to run the code. Be sure to be in the Java folder when running the framework.