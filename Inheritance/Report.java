abstract class Report {
    void runReport() {
        //set up report
    }

    void printReport() {
        //generic printing
    }
}

class Buzzword extends Report {
    void runReport() {
        super.runReport(); // call superclass version; Then come back and do subclass specific stuff
        buzzwordCompliance();
        printReport();
    }
    void buzzwordCompliance() {};
}