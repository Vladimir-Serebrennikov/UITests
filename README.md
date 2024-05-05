# Selenide-cv-data
We get data from Profile and compare with expected data
Test case:
1. Open the Profile from link https://github.com/Vladimir-Serebrennikov;
2. Get profile info using HashMap or Class, which contain attributes:
String gender, int numberOfRepositories, String locationCity, boolean positiveNumberOfContribution;
3. Make sure that expected result and actual result are equals;
   (Expected result: gender="Male", numberOfRepositories>0, locationCity="Saint Petersburg", positiveNumberOfContribution=true);
