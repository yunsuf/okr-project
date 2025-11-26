import React, { useState } from 'react';
import { chatWithOkrs } from '../services/api';

const OkrChat = ({ objectives }) => {
    const [question, setQuestion] = useState('');
    const [chatHistory, setChatHistory] = useState([]);
    const [loading, setLoading] = useState(false);

    const handleAsk = async () => {
        if (!question.trim()) return;

        const newHistory = [...chatHistory, { role: 'user', content: question }];
        setChatHistory(newHistory);
        setLoading(true);
        setQuestion('');

        try {
            const response = await chatWithOkrs(objectives, question);
            setChatHistory([...newHistory, { role: 'ai', content: response.data }]);
        } catch (error) {
            console.error('Error chatting with OKRs:', error);
            setChatHistory([...newHistory, { role: 'ai', content: 'Error getting response.' }]);
        }
        setLoading(false);
    };

    return (
        <div className="bg-white p-6 rounded-lg shadow-md border border-blue-200 h-[500px] flex flex-col">
            <h2 className="text-xl font-semibold mb-4 text-blue-700">Chat with your OKRs</h2>

            <div className="flex-1 overflow-y-auto mb-4 space-y-3 p-2 bg-gray-50 rounded">
                {chatHistory.length === 0 && (
                    <p className="text-gray-400 text-center mt-10">Ask questions about your OKRs...</p>
                )}
                {chatHistory.map((msg, index) => (
                    <div key={index} className={`flex ${msg.role === 'user' ? 'justify-end' : 'justify-start'}`}>
                        <div className={`max-w-[80%] p-3 rounded-lg ${msg.role === 'user'
                                ? 'bg-blue-500 text-white rounded-br-none'
                                : 'bg-white border border-gray-200 rounded-bl-none shadow-sm'
                            }`}>
                            <p className="text-sm whitespace-pre-wrap">{msg.content}</p>
                        </div>
                    </div>
                ))}
                {loading && (
                    <div className="flex justify-start">
                        <div className="bg-gray-100 p-3 rounded-lg rounded-bl-none">
                            <span className="animate-pulse">Thinking...</span>
                        </div>
                    </div>
                )}
            </div>

            <div className="flex gap-2">
                <input
                    type="text"
                    placeholder="Ask a question..."
                    className="flex-1 p-2 border rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
                    value={question}
                    onChange={(e) => setQuestion(e.target.value)}
                    onKeyPress={(e) => e.key === 'Enter' && handleAsk()}
                />
                <button
                    onClick={handleAsk}
                    disabled={loading || !question}
                    className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 disabled:bg-blue-300"
                >
                    Send
                </button>
            </div>
        </div>
    );
};

export default OkrChat;
