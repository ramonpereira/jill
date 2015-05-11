package jill.struct;

/*
 * #%L
 * Jill Cognitive Agents Platform
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

import java.lang.reflect.Method;

public class PlanType extends GPType{
	private Class<?> cPlan;
	private Method mContext;
	private Method mBody;
	
	public PlanType(String name) {
		super(name);
	}

	public Method getContext() {
		return mContext;
	}
	
	public void setContext(Method mContext) {
		this.mContext = mContext;
	}

	public Method getBody() {
		return mBody;
	}
	
	public void setBody(Method mBody) {
		this.mBody = mBody;
	}

	public Class<?> getPlanClass() {
		return cPlan;
	}

	public void setPlanClass(Class<?> cPlan) {
		this.cPlan = cPlan;
	}	
}
