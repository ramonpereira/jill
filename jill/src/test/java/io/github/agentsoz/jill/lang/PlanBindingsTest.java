package io.github.agentsoz.jill.lang;


import io.github.agentsoz.jill.config.GlobalConstant.PlanSelectionPolicy;
import io.github.agentsoz.jill.core.beliefbase.Belief;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Random;

public class PlanBindingsTest {

  @Test
  public void testAdd0() {

    PlanBindings pb = new PlanBindings(null);

    assertTrue(pb.size() == 0);
    pb.clear();
    assertTrue(pb.size() == 0);
    pb.add(null, null);
    assertTrue(pb.size() == 0);

    Plan p1 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };
    LinkedHashSet<Belief> lhs1 = new LinkedHashSet<Belief>();

    pb.add(null, lhs1);
    assertSame(pb.size(),0);
    pb.add(p1, null);
    assertSame(pb.size(),1);
    pb.add(p1, null);
    pb.add(p1, null);
    pb.add(p1, null);
    pb.add(p1, null);
    assertSame(pb.size(),1);

    Plan p2 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };

    pb.add(p2, null);
    assertSame(pb.size(), 2);
    pb.add(p2, lhs1);
    assertSame(pb.size(), 2);

    LinkedHashSet<Belief> lhs2 = new LinkedHashSet<Belief>();
    pb.add(p2, lhs2);
    assertSame(pb.size(), 2);

    LinkedHashSet<Belief> lhs3 = new LinkedHashSet<Belief>();
    lhs3.add(new Belief(0, 0, null));
    pb.add(p2, lhs3);
    assertSame(pb.size(), 2);

    LinkedHashSet<Belief> lhs4 = new LinkedHashSet<Belief>();
    lhs4.add(new Belief(1, 1, null));
    lhs4.add(new Belief(2, 2, null));
    lhs4.add(new Belief(3, 3, null));
    pb.add(p2, lhs4);
    assertSame(pb.size(), 4);

    pb.add(p2, lhs2);
    assertSame(pb.size(), 2);

    Plan p3 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };

    pb.add(p3, lhs4);
    assertSame(pb.size(), 5);

    Plan p4 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };

    pb.add(p4, lhs4);
    assertSame(pb.size(), 8);

  }

  @Test
  public void testGetPlans0() {

    PlanBindings pb = new PlanBindings(null);
    assertNotSame(pb.getPlans(), null);
    assertTrue(pb.getPlans().isEmpty());

    Plan p1 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };

    LinkedHashSet<Belief> lhs1 = new LinkedHashSet<Belief>();

    pb.add(p1, null);
    pb.add(p1, lhs1);
    assertSame(pb.getPlans().size(), 1);
    assertTrue(pb.getPlans().contains(p1));

    Plan p2 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };

    pb.add(p2, null);
    assertSame(pb.getPlans().size(), 2);
    assertTrue(pb.getPlans().contains(p1));
    assertTrue(pb.getPlans().contains(p2));

    Plan p3 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };

    pb.add(p3, null);
    assertSame(pb.getPlans().size(), 3);
    assertTrue(pb.getPlans().contains(p1));
    assertTrue(pb.getPlans().contains(p2));
    assertTrue(pb.getPlans().contains(p3));

    pb.clear();
    pb.add(p3, null);
    assertSame(pb.getPlans().size(), 1);
    assertTrue(!pb.getPlans().contains(p1));
    assertTrue(!pb.getPlans().contains(p2));
    assertTrue(pb.getPlans().contains(p3));

  }

  @Test
  public void testGetBindings0() {

    PlanBindings pb = new PlanBindings(null);
    Plan p1 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };
    LinkedHashSet<Belief> lhs1 = new LinkedHashSet<Belief>();

    pb.add(p1, null);
    assertSame(pb.getBindings(p1), null);

    pb.add(p1, lhs1);
    assertSame(pb.getBindings(p1), lhs1);

    Plan p2 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };

    pb.add(p2, null);
    assertNotSame(pb.getBindings(p1), null);
    assertSame(pb.getBindings(p2), null);

    Plan p3 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };

    assertSame(pb.getBindings(p3), null);
    pb.add(p3, lhs1);
    assertSame(pb.getBindings(p3), lhs1);

    pb.clear();
    assertSame(pb.getBindings(p1), null);
    assertSame(pb.getBindings(p2), null);
    assertSame(pb.getBindings(p3), null);
  }

  @Test
  public void testGet0() {
    PlanBindings pb = new PlanBindings(new Random(1234));
    Agent a1 = new Agent("a1");
    Agent a2 = new Agent("a2");
    Plan p1 = new Plan(a1, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };
    Plan p2 = new Plan(null, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };
    Plan p3 = new Plan(a1, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };
    Plan p4 = new Plan(a2, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };
    Plan p5 = new Plan(a1, null, null) {
      @Override
      public void setPlanVariables(HashMap<String, Object> vars) {}

      @Override
      public boolean context() {
        return false;
      }
    };

    LinkedHashSet<Belief> lhs1 = new LinkedHashSet<Belief>();
    LinkedHashSet<Belief> lhs4 = new LinkedHashSet<Belief>();
    lhs4.add(new Belief(1, 1, null));
    lhs4.add(new Belief(2, 2, null));
    lhs4.add(new Belief(3, 3, null));


    pb.add(p1, lhs4);
    pb.add(p2, lhs4);
    pb.add(p3, null);
    pb.add(p4, null);
    pb.add(p5, lhs1);

    Plan o1 = pb.get(PlanSelectionPolicy.FIRST);
    Plan o2 = pb.get(PlanSelectionPolicy.FIRST);
    Plan o3 = pb.get(PlanSelectionPolicy.FIRST);
    Plan o4 = pb.get(PlanSelectionPolicy.FIRST);
    Plan o5 = pb.get(PlanSelectionPolicy.FIRST);
    assertSame(o1, o2);
    assertSame(o1, o3);
    assertSame(o1, o4);
    assertSame(o1, o5);
    assertSame(o1, p1);

    o1 = pb.get(PlanSelectionPolicy.LAST);
    o2 = pb.get(PlanSelectionPolicy.LAST);
    o3 = pb.get(PlanSelectionPolicy.LAST);
    o4 = pb.get(PlanSelectionPolicy.LAST);
    o5 = pb.get(PlanSelectionPolicy.LAST);
    assertSame(o1, o2);
    assertSame(o1, o3);
    assertSame(o1, o4);
    assertSame(o1, o5);
    assertSame(o1, p5);

    o1 = pb.get(PlanSelectionPolicy.RANDOM);
    o2 = pb.get(PlanSelectionPolicy.RANDOM);
    o3 = pb.get(PlanSelectionPolicy.RANDOM);
    o4 = pb.get(PlanSelectionPolicy.RANDOM);
    o5 = pb.get(PlanSelectionPolicy.RANDOM);
    assertFalse(o1 == o2 && o1 == o3 && o1 == o4 && o1 == o5);
    assertFalse(o2 == o1 && o2 == o3 && o2 == o4 && o2 == o5);
    assertFalse(o3 == o1 && o3 == o2 && o3 == o4 && o3 == o5);
    assertFalse(o4 == o1 && o4 == o2 && o4 == o3 && o4 == o5);
    assertFalse(o5 == o1 && o5 == o2 && o5 == o3 && o5 == o4);

  }

}
