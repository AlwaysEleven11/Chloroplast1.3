package System.util.nativGate;

import java.util.zip.ZipEntry;

public class CarEntry extends ZipEntry {
    /**
     * 以事先规定好的名称创建一个CarEntry。
     *
     * @param name The entry name
     * @throws NullPointerException     if the entry name is null
     * @throws IllegalArgumentException if the entry name is longer than
     *                                  0xFFFF bytes
     */
    public CarEntry(String name) {
        super(name);
    }
    public String getName() {
        return super.getName();
    }
}
