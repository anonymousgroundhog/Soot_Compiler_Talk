/**
 * @param args
 */
public static void main(String[] args) {
 PackManager.v().getPack("jtp").add(new Transform("jtp.fixedie", new BodyTransformer() {
  @Override
  protected void internalTransform(Body b, String phaseName, Map<String, String> options) {
   for (Unit u : b.getUnits()) {
    Stmt s = (Stmt) u;
    if (s.containsInvokeExpr()) {
     InvokeExpr ie = s.getInvokeExpr();
     if (FixedMethods.isFixed(ie)) {
      System.err.println("+++ " + ie);
      yes++;
     } else {
      System.err.println(" -  " + ie);
      no++;
     }
    }
   }
  }
 }));
 soot.Main.main(args);
 System.err.println("+++ " + yes);
 System.err.println(" -  " + no);
}
