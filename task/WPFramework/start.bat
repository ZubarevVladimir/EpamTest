cd "src/main/resources/VagrantWP/"
vagrant up 
cd ..
cd ..
cd ..
cd ..
java -jar WPFramework.jar
cd "src/main/resources/VagrantWP/"
vagrant destroy -f
exit