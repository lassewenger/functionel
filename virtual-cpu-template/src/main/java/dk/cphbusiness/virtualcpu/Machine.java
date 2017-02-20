package dk.cphbusiness.virtualcpu;

import java.io.PrintStream;

public class Machine {
  private Cpu cpu = new Cpu();
  private Memory memory = new Memory();
  
  public void load(Program program) {
    int index = 0;
    for (int instr : program) {
      memory.set(index++, instr);
      }
    }
  
  public void tick() {
    int instr = memory.get(cpu.getIp());
    if (instr == 0b0000_0000) {
      // 0000 0000  NOP
      cpu.incIp();
      // cpu.setIp(cpu.getIp() + 1);
      }
    else if (instr == 0b0000_0001) {
      // 0000 0001 ADD A B
      cpu.setA(cpu.getA() + cpu.getB());
      cpu.setIp(cpu.getIp() + 1);
      }
    // ..
    else if ((instr & 0b1111_0000) == 0b0010_0000) {
      // 0010 r ooo	MOV r o	   [SP + o] ← r; IP++
      
      // 0010 1 011 MOV B (=1) +3  [SP +3] // Move register B to memory position of SP with offset 3
      
      // 00101011 finding instruction
      //    and
      // 11110000
      // --------
      // 00100000
      
      // 00101011 finding offset
      //    and
      // 00000111
      // --------
      // 00000011 = 3
      
      // 00101011 finding register
      //    and
      // 00001000
      // --------
      // 00001000 = 8
      //    >> 3
      // 00000001 = 1
      
      int o = instr & 0b0000_0111;
      int r = (instr & 0b0000_1000) >> 3;
      if (r == cpu.A) memory.set(cpu.getSp() + o, cpu.getA());
      else memory.set(cpu.getSp() + o, cpu.getB());
      cpu.setIp(cpu.getIp() + 1);
      }
    }
  
  public void print(PrintStream out) {
    memory.print(out);
    out.println("-------------");
    cpu.print(out);
    }
  
  }
