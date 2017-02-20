package dk.cphbusiness.towersofhanoi;

import java.util.Stack;

public class Tower {
  private final Stack<Disk> disks = new Stack();
  
  public Tower(int count) {
    for (int size = count + 1; size > 1; size--) {
      disks.push(new Disk(size));
      }
    }

  public boolean moveTo(Tower other) {
    if (disks.empty()) return false;
    if (
        !other.disks.empty() && 
        this.disks.peek().getSize() > other.disks.peek().getSize()
        ) return false;
    other.disks.push(this.disks.pop());
    return true;
    }
  
  public String text(int height) {
    if (height >= disks.size()) return "            |            ";
    return disks.get(height).text();
    }
  
  }
