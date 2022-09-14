import java.util.*;

import soot.*;
import soot.BodyTransformer;
import soot.PackManager;
import soot.Transform;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;

public class TestDominatorFinder {
  static int yes = 0, no = 0;

  /**
   * @param args
   */
  public static void main(String[] args) {
    PackManager.v().getPack("jtp").add(new Transform("jtp.fixedie", new BodyTransformer() {

      @Override
      protected void internalTransform(Body body, String phaseName, Map<String, String> options) {
        System.out.println("Main Class:" + String.valueOf(Scene.v().getMainClass()));
        UnitGraph this_graph = new ExceptionalUnitGraph(body);
        DominatorFinder analysis = new DominatorFinder(this_graph);
        Iterator it = body.getUnits().iterator();
        while (it.hasNext()){
          Stmt statement = (Stmt)it.next();
          List dominators = analysis.getDominators(statement);
          Iterator dominator_iterator = dominators.iterator();
          while (dominator_iterator.hasNext()){
            Stmt ds = (Stmt)dominator_iterator.next();
            String info = statement+" is dominated by "+ds;
            System.out.println(info);

          }
        }
      }

    }));
    soot.Main.main(args);
  }

}