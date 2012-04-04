/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.geronimo.samples.javaee6.jpa20demo.managedbean;

import org.apache.geronimo.samples.javaee6.jpa20demo.ejb.MessageFacade;
import org.apache.geronimo.samples.javaee6.jpa20demo.entity.Message;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "MessageView")
@RequestScoped
public class MessageView {

    @EJB
    private MessageFacade messageFacade;
    private Message message;
    private int[] range;
    private List<Message> rangeList;
    private int start;
    private int end;

    public void setEnd(int end) {
        if (end >= 0 && end >= this.start)
            this.end = end;
        else
            this.end = this.start;
        range[1] = this.end;
    }

    public void setStart(int start) {
        if (start >= 0)
            this.start = start;
        else
            this.start = 0;
        range[0] = this.start;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public int[] getRange() {
        return range;
    }

    public List getdAll() {
        return findAll();
    }

    public List getRangeList() {
        return rangeList;
    }

    /** Creates a new instance of MessageView */
    public MessageView() {
        this.message = new Message();
        range = new int[2];
        range[0] = start;
        range[1] = end;
    }

    // Calls getMessage to retrieve the message

    public Message getMessage() {
        return message;
    }

    // Returns the total number of messages
    public int getNumberOfMessages() {
        return messageFacade.findAll().size();
    }

    // Saves the message and then returns the string "theend"
    public String postMessage() {

        this.messageFacade.create(message);
        return "index";
    }

    public String removeMessage() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        this.message = this.messageFacade.find(Long.parseLong(request
                .getParameter("messageId")));
        this.messageFacade.remove(message);
        return "index";
    }

    public List<Message> findAll() {
        return this.messageFacade.findAll();
    }

    public String findRange() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        rangeList = this.messageFacade.findRange(range);
        return "index";
    }

    public int getCount() {
        return this.messageFacade.count();
    }
}
