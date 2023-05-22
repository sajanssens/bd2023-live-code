package nl.bramjanssens.ocp;

interface Flyer {
    String getName();
}

class Bird implements Flyer {
    protected String name;

    public Bird(String name) { this.name = name; }

    public String getName() { return name; }
}

class Eagle extends Bird {
    public Eagle(String name) { super(name); }
}

class TestClass {
    public static void main(String[] args) throws Exception {
        Flyer f = new Eagle("American Bald Eagle");
        System.out.println(((Eagle) f).name);
    }
}
