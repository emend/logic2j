/*
 * logic2j - "Bring Logic to your Java" - Copyright (C) 2011 Laurent.Tettoni@gmail.com
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.logic2j.model;

import org.logic2j.model.symbol.Struct;
import org.logic2j.model.symbol.StructObject;
import org.logic2j.model.symbol.TDouble;
import org.logic2j.model.symbol.TLong;
import org.logic2j.model.symbol.Term;
import org.logic2j.model.symbol.Var;

/**
 * Generic visitor for the {@link Term} hierarchy.
 * For reference, see the visitor pattern.
 */
public interface TermVisitor<T> {

  public T visit(TLong theLong);

  public T visit(TDouble theDouble);

  public T visit(Var theVar);

  public T visit(Struct theStruct);

  public T visit(StructObject<?> theStructObject);
}
