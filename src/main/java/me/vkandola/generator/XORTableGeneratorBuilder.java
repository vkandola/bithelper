package me.vkandola.generator;

/**
 * Builder for XORTableGenerator.
 */
public class XORTableGeneratorBuilder {
    private XORTableGenerator XORTableGenerator;

    public XORTableGeneratorBuilder() {
        XORTableGenerator = new XORTableGenerator();
    }

    public XORTableGenerator build() {
        return XORTableGenerator;
    }
}
