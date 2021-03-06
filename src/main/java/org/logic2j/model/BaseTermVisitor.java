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
import org.logic2j.model.symbol.Var;

/**
 * Base implementation of {@link TermVisitor} does nothing 
 * except for {@link Struct}, which are traversed recursively until 
 * the first accept() returns non-null.<br/> 
 * Appropriate for searching through structures, or traversing all
 * assuming null is returned.
 */
public class BaseTermVisitor<T> implements TermVisitor<T> {

  @Override
  public T visit(TLong theLong) {
    return null;
  }

  @Override
  public T visit(TDouble theDouble) {
    return null;
  }

  @Override
  public T visit(Var theVar) {
    return null;
  }

  /**
   * Delegate to all subelements.
   */
  @Override
  public T visit(Struct theStruct) {
    // Recurse through children
    for (int i = 0; i < theStruct.getArity(); i++) {
      final T result = theStruct.getArg(i).accept(this);
      // Until the first returning a non-null result
      if (result!=null) {
        return result;
      }
    }
    return null;
  }

  @Override
  public T visit(StructObject<?> theStructObject) {
    return null;
  }
}
