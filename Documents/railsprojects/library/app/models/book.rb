class Book < ActiveRecord::Base
	has_many :reviews
	has_many :reservations
	belongs_to :genre
    
    has_many :comments, :dependent => :destroy
    
    has_many :lineitems
	
	validates :title, presence: true
	validates :title, uniqueness: true
	validates :author, presence: true
	validates :genre, presence: true
    
    def average_rating
        comments.average(:rating)
    end

    def self.search(query)
        where("title LIKE?", "%#{query}")
    end		
end
