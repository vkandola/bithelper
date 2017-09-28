package me.vkandola.generator;

/**
 * A XOR table generator.
 */
public class XORTableGenerator extends TableGenerator {
    // XOR Mask to use.
    private int XORMask = 0;
    // Ranges to stop and start iterating on.
    private int rangeStart = 0;
    private int rangeEnd = 256;
    // Step size
    private int stepSize = 1;
    // How many bits left shifted will the iteration occur
    private int bitShift = 0;


    protected XORTableGenerator() {
        // Only allow the builder to instantiate this object.
    }

    /**
     * Generates the XOR table.
     */
    public void generate() {
        System.out.printf("%-8s | %-11s | %-11s | %-32s\n", "Hex", "Integer", "Unsigned", "Binary");
        String separator = new String(new char[80]).replace('\0', '-');
        System.out.println(separator);
        for (int i = rangeStart; i < rangeEnd; i += stepSize) {
            int maskedAndShiftedValue = XORMask ^ (i << bitShift);
            System.out.printf("%8x | %11d | %11d | %32s\n",
                    maskedAndShiftedValue,
                    maskedAndShiftedValue,
                    maskedAndShiftedValue & 0xFFFFFFFFL,
                    Integer.toBinaryString(maskedAndShiftedValue));
        }
        System.out.println(separator);
    }

    public int getXORMask() {
        return XORMask;
    }

    void setXORMask(int XORMask) {
        this.XORMask = XORMask;
    }

    public int getRangeStart() {
        return rangeStart;
    }

    void setRangeStart(int rangeStart) {
        this.rangeStart = rangeStart;
    }

    public int getRangeEnd() {
        return rangeEnd;
    }

    void setRangeEnd(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public int getStepSize() {
        return stepSize;
    }

    void setStepSize(int stepSize) {
        this.stepSize = stepSize;
    }

    public int getBitShift() {
        return bitShift;
    }

    void setBitShift(int bitShift) {
        this.bitShift = bitShift;
    }
}
