package me.vkandola.generator;

import me.vkandola.generator.XORTableGenerator;

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
