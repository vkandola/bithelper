package me.vkandola.generator;

/**
 * A XOR table generator.
 */
public class XORTableGenerator extends TableGenerator {
    // XOR Mask to use.
    private int XORMask;

    protected XORTableGenerator() {
        // Only allow the builder to instantiate this object.
    }

    /**
     * Generates the XOR table.
     */
    public void generate() {
        System.out.println("I'm a table generator, XOR am I?");
    }

    public int getXORMask() {
        return XORMask;
    }

    void setXORMask(int XORMask) {
        this.XORMask = XORMask;
    }
}
