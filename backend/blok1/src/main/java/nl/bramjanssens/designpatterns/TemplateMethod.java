package nl.bramjanssens.designpatterns;

public class TemplateMethod {

    public static void main(String[] args) {
        new MyBean().lifecycleVanDezeBean();
    }
}

class CDIBean {

    public void lifecycleVanDezeBean() {
        postCreate();
        // doe je ding
        preDestroy();
    }

    // hookable method
    public void postCreate() {
        // default: doe niks
    }

    public void preDestroy() {
        // default: doe niks
    }
}

class MyBean extends CDIBean {

    @Override
    public void postCreate() {
        super.postCreate();
        System.out.println("Ik ben aangemaakt en klaar om te gaan leven");
    }
}
