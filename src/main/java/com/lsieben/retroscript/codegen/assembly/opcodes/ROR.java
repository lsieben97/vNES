package com.lsieben.retroscript.codegen.assembly.opcodes;

import com.lsieben.retroscript.codegen.assembly.AddressingMode;
import com.lsieben.retroscript.codegen.assembly.CycleMeasureMode;
import com.lsieben.retroscript.codegen.assembly.CycleMeasurement;
import com.lsieben.retroscript.codegen.assembly.OpCode;

import static com.lsieben.retroscript.codegen.assembly.Util.tb;

public class ROR extends OpCode {
    @Override
    protected void initialize() {
        this.instructionMap.put(AddressingMode.Accumulator,      tb("6A"));
        this.instructionMap.put(AddressingMode.ZeroPage,         tb("66"));
        this.instructionMap.put(AddressingMode.ZeroPageIndexedX, tb("76"));
        this.instructionMap.put(AddressingMode.Absolute,         tb("6E"));
        this.instructionMap.put(AddressingMode.AbsoluteIndexedX, tb("7E"));


        this.mnemonic = "ROR";
        this.description = "Rotate One Bit Right. Memory or Accumulator";

        this.cycleMap.put(AddressingMode.Accumulator,      new CycleMeasurement(2, CycleMeasureMode.Absolute));
        this.cycleMap.put(AddressingMode.ZeroPage,         new CycleMeasurement(5, CycleMeasureMode.Absolute));
        this.cycleMap.put(AddressingMode.ZeroPageIndexedX, new CycleMeasurement(6, CycleMeasureMode.Absolute));
        this.cycleMap.put(AddressingMode.Absolute,         new CycleMeasurement(6, CycleMeasureMode.Absolute));
        this.cycleMap.put(AddressingMode.AbsoluteIndexedX, new CycleMeasurement(7, CycleMeasureMode.Absolute));
    }
}
