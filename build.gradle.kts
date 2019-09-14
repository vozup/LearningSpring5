plugins { 
  java
  eclipse
}

allprojects {
   group = "it.discovery"
}

subprojects {  
   apply(plugin = "java")

   java.sourceCompatibility = JavaVersion.VERSION_12
   java.targetCompatibility = JavaVersion.VERSION_12

   repositories {
     jcenter()
     maven { url = uri("https://repo.spring.io/milestone") }
   }
   
   dependencies {
        runtime("javax.xml.bind:jaxb-api:2.3.0")
        runtime("javax.annotation:javax.annotation-api:1.3.1")
        compileOnly("org.projectlombok:lombok:1.18.8")
        annotationProcessor("org.projectlombok:lombok:1.18.8")
   } 
}

