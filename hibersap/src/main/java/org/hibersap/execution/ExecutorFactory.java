package org.hibersap.execution;

/*
 * Copyright (C) 2008 akquinet tech@spree GmbH
 * 
 * This file is part of Hibersap.
 *
 * Hibersap is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Hibersap is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Hibersap.  If not, see <http://www.gnu.org/licenses/>.
 */

import org.hibersap.HibersapException;
import org.hibersap.session.Session;


/**
 * @author Carsten Erker
 */
public class ExecutorFactory
{
    public static Executor create( Session session )
    {
        Class<? extends Executor> executorClass = session.getSessionFactory().getSettings().getExecutorClass();
        Executor executor;
        try
        {
            executor = executorClass.newInstance();
            executor.configure( session );
        }
        catch ( InstantiationException e )
        {
            throw new HibersapException( "Executor class can not be instantiated", e );
        }
        catch ( IllegalAccessException e )
        {
            throw new HibersapException( "Executor class can not be instantiated", e );
        }
        return executor;
    };
}
