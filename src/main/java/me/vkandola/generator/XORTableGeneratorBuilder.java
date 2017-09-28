package me.vkandola.generator;

/**
 * Builder for XORTableGenerator.
 */
public class XORTableGeneratorBuilder {
    private XORTableGenerator XORTableGenerator;

    public XORTableGeneratorBuilder() {
        XORTableGenerator = new XORTableGenerator();
    }

    public XORTableGeneratorBuilder withXORMask(int XORMask) {
        XORTableGenerator.setXORMask(XORMask);
        return this;
    }

    public XORTableGenerator build() {
        return XORTableGenerator;
    }
}
