class Member < ActiveRecord::Base
	has_many :reservations
	has_many :reviews
    has_many :comments
    has_many :orders
    
	has_secure_password
	
	validates :name, presence: true
	validates :address, presence: true
	validates :email, presence: true
	validates :phone, presence: true
	#validates _uniqueness_of:email
    
    geocoded_by :address
    after_validation :geocode, :if => :address_changed?
    

end
