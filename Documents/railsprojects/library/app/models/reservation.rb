class Reservation < ActiveRecord::Base
	belongs_to :member
	belongs_to :book
	
	

end
