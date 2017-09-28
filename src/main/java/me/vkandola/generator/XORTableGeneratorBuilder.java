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

    public XORTableGeneratorBuilder withRangeStart(int rangeStart) {
        XORTableGenerator.setRangeStart(rangeStart);
        return this;
    }

    public XORTableGeneratorBuilder withRangeEnd(int rangeEnd) {
        XORTableGenerator.setRangeEnd(rangeEnd);
        return this;
    }

    public XORTableGeneratorBuilder withStepSize(int stepSize) {
        XORTableGenerator.setStepSize(stepSize);
        return this;
    }

    public XORTableGeneratorBuilder withBitShift(int bitShift) {
        XORTableGenerator.setBitShift(bitShift);
        return this;
    }

    public XORTableGenerator build() {
        return XORTableGenerator;
    }
}
