package nl.bramjanssens.nestedclasses;

public class TopLevel {

    private String topLevelField;

    public static class StaticNested {

        String topLevelField;

        public void kanIkBijFields() {
            // this.topLevelField; nee
        }
    }

    public class Inner {

        private String topLevelField;

        public void kanIkBijFields(String topLevelField) {
            System.out.println(topLevelField);
            System.out.println(this.topLevelField);
            System.out.println(TopLevel.this.topLevelField);
        }
    }

    public void eenMethode() {
        System.out.println(this.topLevelField);
        StaticNested sn = new StaticNested();
        System.out.println(sn.topLevelField);

        TopLevel topLevel = new TopLevel();
        TopLevel.Inner inner = topLevel.new Inner();
        System.out.println(inner.topLevelField);
    }

    public static void main(String[] args) {
        TopLevel.StaticNested o1 = new TopLevel.StaticNested();

        TopLevel topLevel = new TopLevel();
        TopLevel.Inner o2 = topLevel.new Inner();
        o2.kanIkBijFields("");
    }
}
