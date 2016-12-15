class SessionsController < ApplicationController
  def new
  end

  def create
      member = Member.find_by_email(params[:email])
      if member && member.authenticate(params[:password])
          session[:member_id] = member.id
		redirect_to session[:return_to] || root_path #1st time logging in shows homepage otherwise show what they were on
	else
		flash.now[:error] = "Invalid email/password combination."
		render 'new'
	 end 
  end

  def destroy
		if signed_in?
            session[:member_id] = nil
		else
			flash[:notice] = "You need to log in first"
        end 
		redirect_to root_path
  
  end
    
    def managementnew
    end
    
    def managementcreate
        management = Management.find_by_username(params[:username])
        if management and management.authenticate(params[:password])
            session[:management_id] = management.id
            redirect_to '/pages/adminhome'
        else
            redirect_to managementlogin_path, alert: "Invalid admin login in combination"
          
        end
        
    end 
    
    def managementdestroy
        session[:management_id] =nil
        redirect_to root_path, notice: "Logged out"
    end 

end
