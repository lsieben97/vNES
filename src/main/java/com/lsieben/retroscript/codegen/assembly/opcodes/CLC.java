package com.lsieben.retroscript.codegen.assembly.opcodes;

import com.lsieben.retroscript.codegen.assembly.AddressingMode;
import com.lsieben.retroscript.codegen.assembly.CycleMeasureMode;
import com.lsieben.retroscript.codegen.assembly.CycleMeasurement;
import com.lsieben.retroscript.codegen.assembly.OpCode;

import static com.lsieben.retroscript.codegen.assembly.Util.tb;

public class CLC extends OpCode {
    @Override
    protected void initialize() {
        this.instructionMap.put(AddressingMode.Implied, tb("18"));

        this.mnemonic = "CLC";
        this.description = "Clear Carry Flag";

        this.cycleMap.put(AddressingMode.Implied, new CycleMeasurement(2, CycleMeasureMode.Absolute));
    }
}
