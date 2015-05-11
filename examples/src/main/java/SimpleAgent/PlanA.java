package SimpleAgent;

/*
 * #%L
 * MOBSS, Masses of BDI-agents for Social Simulation
 * %%
 * Copyright (C) 2014 - 2015 by its authors. See AUTHORS file.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import jill.lang.Agent;
import jill.lang.Plan;
import jill.lang.PlanInfo;
import jill.lang.PlanStep;

@PlanInfo(handlesGoal="SimpleAgent.GoalA", postsGoals={"SimpleAgent.GoalB", "SimpleAgent.GoalC"})
public class PlanA extends Plan { 

	public PlanA(Agent agent, String name) {
		super(agent, name);
		body = steps;
	}

	public String context() {
		return "neighbour(X) && close(X)";
	}
	
	PlanStep[] steps = {
			new PlanStep() {
				public void step() {
					((TestAgent)getAgent()).setI(((TestAgent)getAgent()).getI() | 0x0001);
				}
			},
			new PlanStep() {
				public void step() {
					post(new GoalB("gB"));
				}
			},
			new PlanStep() {
				public void step() {
					post(new GoalC("gC"));
				}
			},
	};
	
}
