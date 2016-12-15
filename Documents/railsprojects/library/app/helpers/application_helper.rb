module ApplicationHelper
		def signed_in?
            if session[:member_id].nil? 
				return 	
			else 
                @current_user = Member.find_by_id(session[:member_id])
				
		end
	end
    
    def managementsigned_in?
        if session[:management_id].nil?
            return
        else
            @managementcurrent_user = Management.find_by_id(session[:management_id])
        end
    end
	
	
end
